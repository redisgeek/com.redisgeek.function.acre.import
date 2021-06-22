[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

# com.redisgeek.function.acre.imports
## Azure Function for ACRE Import

A function to import, an RDB snapshot, from a storage container, to an existing ACRE instance.

### Built with:

* [Spring Cloud Function](https://spring.io/projects/spring-cloud-function)
* [Azure SDK for Java](https://github.com/Azure/azure-sdk-for-java)

## | [Getting Started](#getting-started) | [See Also](#see-also)  | [License](#license) |

## Getting Started

** Prerequisites:**

* Azure Cache for Redis Enterprise
* Storage Account
* Storage Container with RDB snapshot

The function gets is configuration from the environment variables.
The variables are shown in example.local.settings.json.
The values will be grabbed from the prerequisite deployed resources.

When deployed to Azure, you will also need to provide:

- AZURE_SUBSCRIPTION_ID
- AZURE_TENANT_ID
- AZURE_CLIENT_SECRET
- AZURE_CLIENT_ID

### Clone the Repository w/ Submodules

To install this example application, run the following commands:
```bash
git clone git@github.com:redisgeek/com.redisgeek.function.acre.import.git
cd com.redisgeek.function.acre.import.git
```

### Copy configuration template

```bash
cp src/main/azure/example.local.settings.json src/main/azure/local.settings.json
```
>Update local.settings.json with your values

*local.settings.json* is just used for local development.

### Run the function locally

```bash
./mvnw clean package azure-functions:run
```
>Runs the function locally, but connects to Azure Resource Manager

## See Also

[acre-terraform-cron-replication](https://github.com/redisgeek/acre-terraform-cron-replication)

<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/redisgeek/com.redisgeek.function.acre.import/issues) for a list of proposed features (and known issues).

<!-- CONTRIBUTING -->
## Contributing

Pull-requests are welcomed!

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/redisgeek/com.redisgeek.function.acre.import.svg?style=for-the-badge
[contributors-url]: https://github.com/redisgeek/com.redisgeek.function.acre.import/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/redisgeek/com.redisgeek.function.acre.import.svg?style=for-the-badge
[forks-url]: https://github.com/redisgeek/com.redisgeek.function.acre.import/network/members
[stars-shield]: https://img.shields.io/github/stars/redisgeek/com.redisgeek.function.acre.import.svg?style=for-the-badge
[stars-url]: https://github.com/redisgeek/com.redisgeek.function.acre.import/stargazers
[issues-shield]: https://img.shields.io/github/issues/redisgeek/com.redisgeek.function.acre.import.svg?style=for-the-badge
[issues-url]: https://github.com/redisgeek/com.redisgeek.function.acre.import/issues
[license-shield]: https://img.shields.io/github/license/redisgeek/com.redisgeek.function.acre.import.svg?style=for-the-badge
[license-url]: https://github.com/redisgeek/com.redisgeek.function.acre.import/blob/master/LICENSE.txt
