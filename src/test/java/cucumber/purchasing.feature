@tag
  Feature:Request Purchase of an item
    Background:
      Given I landed on Ecommerce page
      @tag2
      Scenario Outline:Positive test of submitting order
        Given Login with <username> and <password>
        When i add product to cart
        And checkout <product name> and submit the order
        Then "Thank you for the order" is diaplyed"
        Examples:
          | username | password | product name |
          |lovelyprasad409@gmail.com|#Ramjeeprasad12345|ZARA COAT 3|


        //you can use tide gerkins