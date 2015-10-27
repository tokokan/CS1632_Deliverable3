CS1632_Deliverable3


User stories (around 5 tests each to make up the 20 total):
-Zookeeper looking up animal information, but is curious about the disambiguation of a word.
-A teacher checking on the references and revisions on an article to make sure that it is an okay source for the students
-Someone who wants to be knowledgeable so they look at the featured articles, the did you know, and the in the news
-Someone who wants to contribute to the page so that they can feel validated, so they use the talk option

(Note: Scenarios is in connextra form or something, as a <role> I want <feature> So that <benefit>
I think It's also useful to have all scenarios of the same user story be indented under the user story itself.
Scenario format: Given <precondition>, When <input/steps> , Then <expected behavior>


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
	(This scenario will fail as a test)

As a movie enthusiast
I would like to see the director's name of a movie
So that I would be more knowledgeable about the movie

	Given that I am on a movie page which is directed by one person
	When I look at the Directed by text
	Then I can see the director's name
	
	Given that I am on a movie page which is directed by 2 person
	When I look at the "Directed by" text
	Then I can see 2 names listed
