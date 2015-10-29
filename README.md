

As a non-English speaker
I want Wikipedia articles in my native language(s)
So that I can understand the article better

	Given that I am on the main page
	When I click on the link "Espanol"
	Then I will be redirect to Spanish Wikipedia page
	
	Given that I open a browser or tab
	When I access Wikipedia page with Spanish prefix in the address
	Then I will be redirect to Spanish Wikipedia page
	
	Given that I am on an Ensligh Wikipedia article which offer Spanish translation
	When I click on the link to Spanish translation
	Then I will be redirect to Spanish article of the original article
	
	Given that I open a brower or a tab
	When I type the English wikipedia article, with Spanish prefix in the address
	Then I will be redirect to Spanish article of the original article
	
	Given that I am on a non-Spanish wikipedia article which does not offer Spanish translation
	When I try to add Spanish prefix in the article's address
	Then I will be notified the article does not exist



As a biography enthusiast
I would like to see in an article about a person's age (if they are living) or their deathdate (if they died already ):
So that my hobby will be completed

	Given that I am on a biographical page of a living person
	When I try to look for his/her general biography info
	Then I will see their current age

	Given that I am on a biographical page of a dead person
	When I try to look for his/her general biography info
	Then I will see the date when they died
	
	Given that I am on a biographical page of a fictional character
	When I try to look for his/her/it general biography
	Then I will not be able to see their real time age/death

As a movie enthusiast
I would like to see the director's name of a movie
So that I would be more knowledgeable about the movie

	Given that I am on a movie page which is directed by one person
	When I look at the Directed by text
	Then I can see the director's name
	
	Given that I am on a movie page which is directed by 2 person
	When I look at the "Directed by" text
	Then I can see 2 names listed

As a citizen of Otter, Ontario
I want to be able to find the wikipedia page of my hometown
So that I can add important local information

	Given that I am on a wikipedia page with disambiguation
	When I click the 'page-name (disambiguation)' link
	Then I should arrive at the disambiguation page

	Given that I am on a disambiguation page
	When I select a navigation element from the Contents bar
	Then I should be moved to that section of the contents

	Given that I am at the disambiguation page
	When I toggle to hide the Contents Bar
	The contents should no longer be visible

	Given that I am on the disambiguation page
	When I select the Wikitionary link
	I should be moved to a Wikitionary URL

	Given that I am on the disambiguation page
	When I select a link in the body
	I should be moved to a url that is a disambiguation of the original page

As a Biologist
I would like to be able to log in
So that I can add pages about my specialties to my watchlist

	Given that I am on a wikipedia page and not logged in
	When I press the button to log in
	I will be taken to a log-in page

	Given that I am on a wikipedia page
	When I try to log into an account with valid credentials
	Then my username will be displayed on the next page

	Given that I am on a wikipedia page
	When I try to log into an account with invalid credentials, such as a swapped username and password
	Then my username will be not displayed on the next page

	Given that I am on a wikipedia page and logged in
	When I try to clock on the log out button
	Then I will no longer be logged in to wikipedia

	Given that I am on a wikipedia page and logged in
	When another tap is open and navigated to wikipedia
	Then I will still be logged in

(Account used for testing:
Username: CS1632testaccount
Password: Laboooooon)