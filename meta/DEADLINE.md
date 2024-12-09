# Deadline

Modify this file to satisfy a submission requirement related to the project
deadline. Please keep this file organized using Markdown. If you click on
this file in your GitHub repository website, then you will see that the
Markdown is transformed into nice-looking HTML.

## Part 1.1: App Description

> Please provide a friendly description of your app, including
> the primary functions available to users of the app. Be sure to
> describe exactly what APIs you are using and how they are connected
> in a meaningful way.

    This app allows a user to search for movies using the Open movie database API.
    The application take the user's search and searches the Open movie database API,
    displays key information including the title, movie poster, and other various information,
    the app then uses the movie's title as recieved by the open movie database and requests a
    summaray of the movie from the Open Ai chatgpt bot. It the displays all of the information for
    the user to see

> **Also, include the GitHub `https` URL to your repository.**

https://github.com/AToeppner/cs1302-api-app

## Part 1.2: APIs

> For each RESTful JSON API that your app uses (at least two are required),
> include an example URL for a typical request made by your app. If you
> need to include additional notes (e.g., regarding API keys or rate
> limits), then you can do that below the URL/URI. Placeholders for this
> information are provided below. If your app uses more than two RESTful
> JSON APIs, then include them with similar formatting.

### API 1

```
http://www.omdbapi.com/?t=Harry+Potter&y=2000
```

> Replace this line with notes (if needed) or remove it (if not needed).

### API 2

```
curl https://api.openai.com/v1/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer OPEN_API_KEY" \
  -d '{
    "model": "gpt-3.5-turbo",
    "prompt": "Summarize the plot of the Harry Potter series in a few sentences.",
    "max_tokens": 150,
    "temperature": 0.7
  }'
```

>The chatgpt search is a lot more tedious and requires a lot of formatting to request it.
    It is just chatgpt though so if you wanted to test it just type your answer into the website.

## Part 2: New

> What is something new and/or exciting that you learned from working
> on this project?

This is probably the biggest project Ive ever worked on from scratch. I will say it has shown me that I am
    interested in cs because even if I was spending hours trying to fix something I could pay attention and stay
    interested in the the project the whole time.

## Part 3: Retrospect

> If you could start the project over from scratch, what do
> you think might do differently and why?

Definitely more planning, understanding of basic components/ how the app is going to work overall.
    I would have spent a lot less time if I knew exaclty what I wanted to achieve rather than trying
    to do everything all at once. Also I dont like javafx.
