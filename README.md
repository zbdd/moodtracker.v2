YouMood
=========
Moodtracker.v2
---------
YouMood is a simple Android application that lets you post how you feel on a rating from 1-5 for any particular day and time.

There are additional optional elements such as Activities and Feelings experienced at that time for you to track.

Version 2
-------------
YouMood is version 2 of the original Moodtracker project I made. This time, from the ground up it's utilising modern practices to speed up development time,
lower technical debt and also to enable good test-driven development.

The project follows the MVVM framework for Android App Development, with the Model layer consisting of the BaseRepository interface that defines what every database implementation should expose to the View layer.

The View layer handles processing objects from the Model layer and interfacing with the ViewModel layer. Property(s) state goes here.

The ViewModel layer implements JetBrains brilliant new UI-as-code library known as Compose. Should be largely stateless and just render whatever content the associated View class serves up.

MVVM 
----------
![Imgur Image](https://i.imgur.com/ut44I6C.png)

The model layer 
----------
![Imgur Image](https://i.imgur.com/4Jxx2TH.png)
