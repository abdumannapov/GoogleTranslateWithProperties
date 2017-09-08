@SmokeTest
Feature: As a User, I want to use google search
	so that I can search for information
	Scenario: Search a java topic
	Given On Google search result page
	When I enter search item java and click search buttom
	Then Search result page for java should be displayed