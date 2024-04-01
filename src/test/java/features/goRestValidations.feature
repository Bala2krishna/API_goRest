#Author: btulshalapuram
#Summary :Using Dummy fake API named GoRest for the POC pupose.


Feature: Validate the GORest API's
  I want to use this template for my feature file



    Scenario: Verify able to Create a new user in GORest using create a new user API
    Given I have request payload and have authorization key to add user in GoRest
    When I call "add_User" API with "POST" http request
    Then I should get status code as 201
    Then status as "Created"
    
   
    Scenario: Verify able to get specific user in GORest using get user API
    GivenI have have authorization key to get users in GoRest
    When I call "get_Users" API with "GETusers" http request
   Then I should get status code as 200
   And status as "OK"
#
#
  Scenario: Verify able to get specific user in GORest using get user API
    Given I have userID and have authorization key to get user in GoRest
    When I call "get_User" API with "GETUser" http request
   Then I should get status code as 200
   And status as "OK"
#
#
  Scenario: Verify able to update specific user in GORest using put/patch user API
    
    #Given I have "userID" and have authorization key to update user in GoRest
    
    Given I have userID and have authorization key to get user in GoRest
    When I call "update_user" API with "PATCH" http request
    Then I should get status code as 200
    And status as "OK"
    #
   # And status as "ok" with "userID" in responses
#HTTP/1.1 200 OK
 #
  Scenario: Verify able to delete specific user in GORest using delete user API
  
    #Given I have userID and have authorization key to delete user in GoRest
   
    Given I have userID and have authorization key to get user in GoRest
    When I call "delete_User" API with "DELETE" http request
    Then I should get status code as 204
    And status as "No Content"
    

    #HTTP/1.1 204 No Content
    

     #And status as "ok" with "userID" in responses