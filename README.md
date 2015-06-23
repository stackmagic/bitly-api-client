bit.ly api client built in java
===============================

Build Status: !https://secure.travis-ci.org/stackmagic/bitly-api-client.png?branch=master!

[ ![TravicCI](https://travis-ci.org/stackmagic/bitly-api-client.svg?branch=master) ](https://travis-ci.org/stackmagic/bitly-api-client)
[ ![Download](https://api.bintray.com/packages/stackmagic/maven/bitly-api-client/images/download.svg) ](https://bintray.com/stackmagic/maven/bitly-api-client/_latestVersion)

This is a simple java client for the [bit.ly v3 api](http://dev.bitly.com/api.html). It is:

* at version 0.8.0 (some deprecated calls from 0.7.x were removed)
* small
* easy to use
* fairly complete
* built with gradle
* reasonably bugfree
* with a minimum of dependencies
* licensed under the apache license 2.0

I use versions in the form of `x.y.z` - please do not expect compatibility if `x` or `y` has changed, if only `z` has changed there might be a chance that releases are compatible, the reason being that there is still a lot of refactoring going on and there will still be quite a bit of that for some time.

For information on the current feature-set have a look at the file `CHANGELOG`

Get Involved!
-------------

If you want a feature/bugfix go ahead, fork this repo, make a fix (on the development branch) and send me a pull request! :)

Get Started Right Away
----------------------

STEP 0: Get The Library
----------------------

The lib is published on bintray and linked with the jcenter repository:
https://bintray.com/stackmagic/maven/bitly-api-client

*Gradle Setup*

The [jcenter() shortcut requires at least gradle 1.7](http://www.gradle.org/docs/1.7/release-notes#jcenter-repository-support)

```groovy
buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath 'net.swisstech:bitly-api-client:+'
    }
}
```

*Maven Setup*

```xml
<repository>
    <id>central</id>
    <name>bintray</name>
    <url>http://jcenter.bintray.com</url>
</repository>

<dependencies>
    <dependency>
        <groupId>net.swisstech</groupId>
        <artifactId>bitly-api-client</artifactId>
        <version>...</version>
    </dependency>
</dependencies>
```

STEP 1: Get An OAuth Access Token (from bit.ly)
-----------------------------------------------

There is one prerequisite: you need to obtain an oauth access token from bit.ly (which also requires you to [have an account with bit.ly](https://bitly.com/a/sign_up) and [register an app in the dev center](http://bitly.com/a/settings/advanced)). You can do this with [scribe-java](https://github.com/fernandezpablo85/scribe-java) but bit.ly support is not yet available. I made a fork of the scribe project and added bit.ly support. A pull request is currently pending. In the mean time: use my fork (or just the `BitlyApi` class from it) which is available here: https://github.com/stackmagic/scribe-java.

STEP 2: Check Out The Integration Tests
---------------------------------------

There are a bunch of integration tests that you can run and look at to get an idea of how this stuff works. The tests are all matching `**/*IntegrationTest.java` inside `src/test/java`.

In order to run the integration tests you must put your access token into a file with a single line and no leading or trailing spaces named `.accesstoken` inside the project's root directory.

Please note that some of the integration tests may fail for you since you don't have the correct access token and so you'll end up trying to manipulate some of "my" links which will of course fail, at least it should.

STEP 3: Get Cracking (Fluent Builders)
--------------------------------------

The basic principle is simple: You create a BitlyClient with your access token. This is your factory and can be reused and passed around instead of passing around the access token String. Let the `BitlyClient` create a `RequestBuilder` for you and configure it, then make the call to bitly and work with the response. Simple, right? So here goes:

```
BitlyClient client = new BitlyClient("... the access token ...")
Response<ShortUrl> respShort = client.shorten() //
    .setLongUrl("https://github.com/stackmagic/bitly-api-client") //
    .call();
```

This simple 2-liner (newlines added for readability) shortens a link for you! If you do just a few calls or feeld more comfortable with passing the access token instead of the `BitlyClient` instance around, you can instantiate the `RequestBuilder` specializations directly. So above example would become this:

```
Response<ShortUrl> respShort = new ShortenRequestBuilder("... the access token ...") //
    .setLongUrl("https://github.com/stackmagic/bitly-api-client") //
    .call();
```

And it's a 1-liner (but less pretty IMO).

STEP 3: Get Cracking (Traditional Style)
----------------------------------------

If you don't like fluent builders the above example can also be written like this:

```
ShortenRequestBuilder builder = new ShortenRequestBuilder("... the access token ...")
builder.longUrl("https://github.com/stackmagic/bitly-api-client");
Response<ShortUrl> respShort = builder.call();
```

STEP 4: Working With The Response Object
----------------------------------------

The `Response<T>` is a container that contains 3 important fields:

* status_code
* status_txt
* data

The `data` field contains the actual response information of type `T`. It is possible, that the `data` field is null. As of now, it is your obligation to check the status_code and act accordingly. No exceptions are thrown if an error response is received. "The meaning of the status_code":http://dev.bitly.com/formats.html is well documented by bitly.

Roadmap
-------

Right now this project is a rough skeleton. the api style is pretty much defined unless some unexpected special case comes up. the next most important steps are:

* distinguish between single and multi occurrence parameters. some endpoints allow batching, this is not yet implemented in the request builder.
** eliminate duplicate values. eg ?url=a&url=a should be collapsed into a sinlge url=a
** include api limits (e.g. a paramter x may only be added 15 times for batching)
* implement the full api
* refine maven repo and release/publish process, use that maven release repo like it's intended to be used
* add some javadoc
* throw exceptions when there is a `status_code` that doesn't equal 200? make this optional (eg call() and callWithException()?)
* add some debugging output (what's the smallest logging api in terms of size and further dependencies?)
* need to cleanup the model package(s) and model class name(s) but the api is kind of a mess with 2 and 3 level deep links so how do I name stuff? especially the response objects

Design / Naming Conventions
---------------------------

The client follows a few simple rules:

* for each request there is a sinlge response dto class
* the response dto may contain more inner classes if required to model the data structures returned from the api
* all attributes of the dto's are public, no getters or setters to keep things as simple as possible (getter/setter might be introduced later on)
* if an api url reads `/v3/hey/how_are_you` then the corresponding classes' names will start with `HeyHowAreYou` (for the request builder and response dtos)
* dependencies to external libraries are kept to a minimum

Questions / Bugs
----------------

Feel free to raise a bug or question here: https://github.com/stackmagic/bitly-api-client/issues
