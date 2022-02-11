
@parametreliTest
Feature: US1003 parametre ile stepdefinition olusturma

  Scenario: TC05_parametre kullanimi

    Given kullanici amazon sayfasina gider
    And "Java" icin arama yapar
    Then sonuclarin "Java" icerdigini test eder
    And sayfayi kapatir