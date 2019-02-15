Feature: Search Api Feature
@movie
  Scenario Outline: Search Movie with title and Valid API Key

    Given the user have an  valid Api Key
    When the user hits url with movie <title> using the key
    And  we get a success <responseCode>
    Then user should see the search results


    Examples:
       | title  | responseCode |
       | "Moana" | 200 |
       | "Frozen" | 200 |

  @tv
  Scenario Outline: Search TV shows with title and Valid API Key

    Given the user have an  valid Api Key
    When the user hits url with tv show <title> using the key
    And  we get a success <responseCode>
    Then user should see the search results

    Examples:
     | title | responseCode |
     | "Friends" | 200 |
     | "Game of Thrones" | 200 |

  @tv
  Scenario Outline: Search with Invalid API Key

    Given the user have an invalid  Api Key
    When the user hits url with tv show <title> using the key
    Then  user should get a failure <responseCode>

    Examples:
      | title | responseCode |
      |"nemo" | 401 |

  @movie
  Scenario Outline: Search with Invalid API Key

    Given the user have an invalid  Api Key
    When the user hits url with movie <title> using the key
    Then  user should get a failure <responseCode>

    Examples:
      | title | responseCode |
      |"nemo" | 401 |

  @movie
  Scenario Outline: Search with no movie title

    Given the user have an  valid Api Key
    When the user hits url with movie <title> using the key
    Then  user should get a failure <responseCode>

    Examples:
      | title | responseCode |
      |"" | 422 |

  @tv
  Scenario Outline: Search with no tv title

    Given the user have an  valid Api Key
    When the user hits url with tv show <title> using the key
    Then  user should get a failure <responseCode>

    Examples:
      | title | responseCode |
      |"" | 422 |

  @tv
  Scenario Outline: Search with blank tv title

    Given the user have an  valid Api Key
    When the user hits url with tv show <title> using the key
    Then  user should get a failure <responseCode>

    Examples:
      | title | responseCode |
      |" " | 200 |

  @movie
  Scenario Outline: Search with blank movie title

    Given the user have an  valid Api Key
    When the user hits url with movie <title> using the key
    Then  user should get a failure <responseCode>

    Examples:
      | title | responseCode |
      |" " | 200 |