# NoBlockUpdate

[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=for-the-badge)](https://github.com/RichardLitt/standard-readme)
[![discord-banner](https://img.shields.io/discord/1258062506270654515?label=discord&style=for-the-badge&color=7289da)](https://discord.kubbidev.com)

NoBlockUpdate is a **Minecraft plugin** that prevents all kinds of world block updates and physical events.

It is:

* **fast** - written with performance and scalability in mind.
* **free** - available for download and usage at no cost, and permissively licensed so it can remain free forever.

## Table of contents

- [Building](#building)
- [License](#license)

## Building

NoBlockUpdate uses Gradle to handle dependencies & building.

#### Requirements

* Java 21 JDK or newer
* Git

#### Compiling from source

```sh
git clone git@gitlab.com:deplored/noblockupdate.git
cd noblockupdate/
./gradlew build
```

You can find the output jars in the `build/libs` directory.

## License

This project is licensed under the [Apache License Version 2.0](LICENSE.txt).