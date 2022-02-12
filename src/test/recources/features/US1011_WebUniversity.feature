Feature: US1011 Web University Window Handle

  Scenario Outline: TC16 Reusable Methods ila Window Handle Testi

    Given kullanici "WebUniversityUrl" sayfasina gider
    And Login Portala  kadar asagi iner
    And Login Portala tiklar
    Then Acilan diger window'a gecer
    And "<username>" ve  "<password>" kutularina deger yazdirir
    And WebUniversity Login butonuna basar
    And Popup'ta cikan yazinin "validation failed" oldugunu test eder
    Then Ok diyerek Popup'i kapatir
    And Ilk sayfaya geri doner
    Then Ilk sayfaya donuldugunu test eder



    Examples:
    |username|password|
    |Mustafa  |Donat  |