# Simple Guide

![last_update_shield](https://img.shields.io/badge/Last%20Update-March%202025-orange)
![license_shield](https://img.shields.io/github/license/fyiernzy/UM-WIA1002)
![[pipeline_status]](https://img.shields.io/github/actions/workflow/status/fyiernzy/um-tools/ci.yml)




This is a simple yet useful Java package that provides common utilities for WIX1002 and WIA1002.

To get started, create a Maven project and add the following code to your `.m2/settings.xml`:

```xml
<repository>
  <id>github</id>
  <url>https://maven.pkg.github.com/fyiernzy/um-tools</url>
  <snapshots>
    <enabled>true</enabled>
  </snapshots>
</repository>
```

Next, add the following to configure your authentication:

```xml
<servers>
    <server>
      <id>github</id>
      <username>USERNAME</username>
      <password>TOKEN</password>
    </server>
</servers>
```

Make sure to replace `USERNAME` with your GitHub username and `TOKEN` with your Personal Access Token (PAT). For instructions on creating a PAT, refer to this [tutorial](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-personal-access-token-classic).

# Star the Repo

Don't forget to `star` this repository to receive the latest updates. The repository may be updated from time to time to make the code simpler, add comments, add `README.md` files, or even add self-written notes to help others understand the code better.

# Contribution

Should you wish to contribute to this repository, feel free to create a pull request. To know more about pull request and how to do it, please refer to the following GitHub Documentations:

* [**About Pull Requests in GitHub**](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests)
* [**Creating Pull Requests**](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request)
