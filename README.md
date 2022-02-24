# spring-data-access

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

 

TODO: Fill out this long description.

## Table of Contents

- [Install](#install)
- [Usage](#usage)
- [Maintainers](#maintainers)
- [Contributing](#contributing)
- [License](#license)

## Install

```
git clone https://github.com/Jorgsaa/spring-data-access.git
```

## Usage

### Gradle
```
cd spring-data-access
.\gradlew bootRun
```

### Build & Run Docker container
```
cd spring-data-access
docker build --build-arg JAR_FILE=build/libs/\*.jar -t jorgsaa/spring-data-access --no-cache .
docker run -p 8080:8080 jorgsaa/spring-data-access
```

## Maintainers

[Jonas Bergkvist Melå @Pucko321](https://github.com/Pucko321) \
[Jonas Kristoffersen @jonaskris](https://github.com/jonaskris) \
[Jørgen Saanum @Jorgsaa](https://github.com/Jorgsaa)

## Contributing

PRs accepted.

Small note: If editing the README, please conform to the [standard-readme](https://github.com/RichardLitt/standard-readme) specification.

## License

MIT © 2022 Jonas Bergkvist Melå, Jonas Kristoffersen, Jørgen Saanum
