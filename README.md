<h1 align="center">
  <a href="https://github.com/CodeDojoOfficial/FlowentAPI/edit/master/README.md"><img src="https://codedojoofficial.github.io/image/flowent-logo.png" alt="Flowent - Fluent Interface API" width="200"></a>
  <br>
  Flowent Java API
  <br>
  <br>
</h1>

<p align="center">
  <a href="https://shields.io"><img src="https://img.shields.io/badge/fluent-interface-yellow.svg"/></a>
  <a href="https://shields.io"><img src="https://img.shields.io/badge/language-java-blue.svg"/></a>
  <a href="https://shields.io"><img src="https://img.shields.io/badge/jdk-1.8.0-orange.svg"/></a>
  <!-- Semi-dynamic badge comes directly from Travis-CI's badge generator for builds -->
  <a href="https://travis-ci.org"><img src="https://api.travis-ci.org/CodeDojoOfficial/FlowentAPI.svg?branch=master"/></a>
</p>

## Java Fluent interface API

This library gives you the chance to create programs in a method chain style! Look at the abilities!

- Print anything to the console
- Wait for however long you want
- Exit with a custom message and exit code
- **Featured:** Create custom commands and call them from within your method chain!

You won't be limited to what you can do, just like normal programming!

install with:

```
github:~ $ git clone https://github.com/CodeDojoOfficial/FlowentAPI.git
github:~ $ cd FlowentAPI/releases/
github:releases $ mv flow-1.0.0.jar ~/workspace/flow.jar
```

## Table of Contents

- [Quick start](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#quick-start)
  - [Installation](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#installation)
- [FAQ](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#faq)
  - [If you have custom functions, what's the point of the built-in ones?](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#if-you-have-custom-functions-what-s-the-point-of-the-built-in-ones)

## Quick Start

Let's start your first few test programs. In this section, you will build the hello world program, an introduction to custom methods, and a counting method! Let's install this first.

## Installation

To install using git, run the following command:

```
github:~ $ git clone https://github.com/CodeDojoOfficial/FlowentAPI.git
```

The next few instructions are IDE specific. If you are using something like Vim or Nano, or any other IDE that doesn't only support java, you will have to just use javac and java.

### Eclipse IDE

1. Open Eclipse and right-click on the project name in the Package Explorer.
2. Select Properties.
3. Double-click Java Build Path.
4. Click Add Library.
5. User Library > Next
6. If the Flowent Library is here, select it and click finish. Your done.
7. Click User Libraries...
8. Click New.

### NetBeans IDE

1. Open NetBeans and right-click on the project name in the Projects tab.
2. Select Properties.
3. Select Libraries.
4. Click the Add Jar/Folder button.
5. Select ~/FlowentAPI/releases/flow-1.0.0.jar or the latest version.
6. Click Ok.

## FAQ

We know you have many questions about Flowent, and we are happy to answer them. The next few headers answer the most commonly asked questions.

## If you have custom functions, what's the point of the built-in ones?

Yes, there is the ability to create custom functions. But first of all, methods are called from macros. So if there were no macros, Flowent would have no point in existing. Second of all, if you have many custom methods, your code can start to get a little messy. Leave the messiness to us. Give yourself a clean slate to work with so that you can use less space.
