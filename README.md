# Age Calculator

It's a amazing java library that simplifies the calculation of the age from birthday.

How
---

```java
QNCache cache = new QNCacheBuilder().createQNCache();

cache.set("key", "value", 60 * 1000); // It can store things for a minute,
cache.set("key", "value", 60 * 60 * 1000); // for an hour,
cache.set("key", "value", 0); // or forever.
cache.set("key", "value"); // And also for the short version of forever.

cache.get("key"); // It can get them again,
cache.remove("key"); // and remove it if you want.

cache.get("unExistingKey"); // If something doesn't exists, it returns null
cache.get("tooOldKey"); // The same if a key is too old

cache.clear(); // You can also clean it,
cache.size(); // and ask it how many elements it has

QNCache<String> stringCache = new QNCacheBuilder().createQNCache(); //You can also make it typesafe
stringCache.set("key", 42); //so this line does not compile :)
```

Let's talk about the memory
---------------------------
By default, the cache stores a reference to all stored instances, doesn't matter if they're fresh or not. If you plan to store huge instances, like an Android's Bitmap, you can create it with an auto releaser. Then the cache will remove the old elements after the given amount of time.

```java
QNCache cache = new QNCacheBuilder().setAutoReleaseInSeconds(1).createQNCache(); //frees the memory every second
QNCache cache = new QNCacheBuilder().setAutoReleaseInSeconds(60).createQNCache(); //frees the memory every minute
QNCache cache = new QNCacheBuilder().setAutoReleaseInSeconds(60*60).createQNCache(); //frees the memory every hour
QNCache cache = new QNCacheBuilder().createQNCache(); //will never free the invalidated items from memory
```

Are the keys case sensitive?
---------------------------
By default, yes. But you can also specify it at building time.

```java

#Download

* Get <a href="https://github.com/Fewlaps/quitnow-cache/releases/download/v3.0.0/quitnow-cache-3.0.0.jar">the latest .jar</a>

* Grab via Gradle:
```groovy
repositories { jcenter() }
    
compile 'com.ullahbluh.tools:age-calculator:1.0.0'
```

* Grab via Maven:
```xml
<repository>
  <id>jcenter</id>
  <url>http://jcenter.bintray.com</url>
</repository>

<dependency>
  <groupId>com.ullahbluh.tools</groupId>
  <artifactId>age-calculator</artifactId>
	<version>1.0.0</version>
</dependency>

```


## LICENSE ##

The MIT License (MIT)

Copyright (c) 2015 Fewlaps

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
