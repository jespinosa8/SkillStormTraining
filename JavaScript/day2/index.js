/**
 * Here is the javascript for index.html for the Movies API
 */

const URL = 'http://localhost:8282/movies';
let allMovies = [];

/**
 * document - gives access to html elements
 *
 * event listeners are how we respond to events on the html
 */
document.addEventListener('DOMContentLoaded', () => {
  /**
   * DOM - Document Object Model
   *
   * DOMContentLoaded is an event that fires when the DOM is loaded
   *        page loads and refreshes
   */

  /**
   * AJAX - Asynchronous JavaScript and XML
   *
   *   the primary object of AJAX, is XmlHttpRequest (XHR)
   */

  let xhr = new XMLHttpRequest(); // creating a new XHR object (this puts it into state 0 - unsent)

  /**
   * onreadystatechange - is a callback that fires every time the state of the xhr changes
   *
   *      5 stages (ready states):
   *          0 - unsent
   *          1 - opened
   *          2 - headers received
   *          3 - loading
   *          4 - done      ----> this is the main one we care about
   *
   */

  xhr.onreadystatechange = () => {
    /**
     * strict equality (===) and regular equality (==) in JS
     *    strict equality checks values and data types
     *    regular equality onlt checks values
     *
     *    ex: 4 === '4' // false
     *        4 == '4'  // true
     *
     */
    if (xhr.readyState === 4) {
      // at readyState 4, we have our response from the server

      // responseText contained the response form the server
      // JSON.parse() parses the JSON into js objects
      let movies = JSON.parse(xhr.responseText);

      // add movie to tables
      movies.forEach((newMovie) => {
        addMovieToTable(newMovie);
      });
    }
  };

  // use open to set the request method and the url to send the request to (state changed to 1)
  xhr.open('GET', URL);

  // this sends the request
  xhr.send();
});

document
  .getElementById('new-movie-form')
  .addEventListener('submit', (event) => {
    // event object gives info about the event that we are listening for
    event.preventDefault();

    /**
     * one option to grab form data is to call document.getElementById() for each input field
     *
     * a better option is to use FORM DATA
     *
     * FormData provides all the data from a form in an easy to work with object
     */

    // FormData takes in the html tags for your form
    let inputData = new FormData(document.getElementById('new-movie-form'));

    let newMovie = {
      title: inputData.get('new-movie-title'), // use .get to retrieve a field from form data and pass in the NAME attribute from the <input> tag
      rating: inputData.get('new-movie-rating'),
      director: {
        firstName: inputData.get('new-director-first'),
        lastName: inputData.get('new-director-last'),
      },
    };

    doPostRequest(newMovie);
  });

/**
 * rather than using raw xhr objects, we can use fetch()
 *
 * fetch() is a built-in function that can send http requests
 *    fetch() returns a Promise
 *
 *    PROMISES
 *        something that will return.. eventually
 *        happens asynchronously from the rest of your program
 *
 *    ASYNC and AWAIT
 *      use async on a function to tell your program that the function returns a Promise
 *
 *      use await to tell our program to wait for some asynchronous operation
 *          they can ONLY be used inside async functions
 */

async function doPostRequest(newMovie) {
  let returnedData = await fetch(URL + '/movie', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json', // makes sure your server is expecting to receive JSON in the body
    },
    body: JSON.stringify(newMovie), // turns a js object into JSON
  });

  // .json() to deserialize the JSON back into JS object - this ALSO returns a promise
  let movieJson = await returnedData.json();

  // just need to add movie to table
  addMovieToTable(movieJson);

  // reset the form
  document.getElementById('new-movie-form').reset();
}

function addMovieToTable(newMovie) {
  // DOM Manipulation - where we manually change the DOM

  // creating all necessary DOM elements
  let tr = document.createElement('tr'); // will create a <tr> tag
  let id = document.createElement('td'); // will create a <td> tag for the movie id
  let title = document.createElement('td'); // will create a <td> tag for the movie title
  let rating = document.createElement('td'); // will create a <td> tag for the movie rating
  let director = document.createElement('td'); // will create a <td> tag for the director
  let editBtn = document.createElement('td'); // will create a <td> tag for edit button
  let deleteBtn = document.createElement('td'); // will create a <td> tag for the delete button

  id.innerText = newMovie.id;
  title.innerText = newMovie.title;
  rating.innerText = newMovie.rating;
  if (newMovie.director != null) {
    director.innerText =
      newMovie.director.firstName + ' ' + newMovie.director.lastName;
  }

  editBtn.innerHTML = `<button class="btn btn-primary" id="edit-button" onclick="activateEditForm(${newMovie.id})">Edit</button>`;

  deleteBtn.innerHTML = `<button class="btn btn-primary" id="delete-button" onclick="activateDeleteForm(${newMovie.id})">Delete</button>`;

  // adds the td tags as nested children to the tr tag
  tr.appendChild(id);
  tr.appendChild(title);
  tr.appendChild(rating);
  tr.appendChild(director);
  tr.appendChild(editBtn);
  tr.appendChild(deleteBtn);

  // setting the id attribute for the <tr>
  tr.setAttribute('id', 'TR' + newMovie.id);

  // adds the <tr> tage to the <tbody> tag
  document.getElementById('movie-table-body').appendChild(tr);

  // adding the new movie to the list of all the movies
  allMovies.push(newMovie);
}

function activateEditForm(movieId) {
  // find the movie and its <tr> that needs to be edited
  for (let m of allMovies) {
    if (m.id === movieId) {
      document.getElementById('update-movie-id').value = m.id;
      document.getElementById('update-movie-title').value = m.title;
      document.getElementById('update-movie-rating').value = m.rating;
      document.getElementById('update-director-id').value = m.director.id;
      document.getElementById('update-director-first').value =
        m.director.firstName;
      document.getElementById('update-director-last').value =
        m.director.lastName;
    }
  }

  // showing only the edit form
  document.getElementById('new-movie-form').style.display = 'none';
  document.getElementById('update-movie-form').style.display = 'block'; // block is the default for showing a tag
  document.getElementById('delete-movie-form').style.display = 'none';
}

function activateDeleteForm(movieId) {
  // find the movie and its <tr> that needs to be edited
  for (let m of allMovies) {
    if (m.id === movieId) {
      document.getElementById('delete-movie-id').value = m.id;
      document.getElementById('delete-movie-title').value = m.title;
      document.getElementById('delete-movie-rating').value = m.rating;
      document.getElementById('delete-director-id').value = m.director.id;
      document.getElementById('delete-director-first').value =
        m.director.firstName;
      document.getElementById('delete-director-last').value =
        m.director.lastName;
    }
  }

  // showing only the edit form
  document.getElementById('new-movie-form').style.display = 'none';
  document.getElementById('delete-movie-form').style.display = 'block'; // block is the default for showing a tag
  document.getElementById('update-movie-form').style.display = 'none';
}

document.getElementById('cancel-button').addEventListener('click', (event) => {
  event.preventDefault();

  document.getElementById('new-movie-form').reset();
  document.getElementById('update-movie-form').reset();
  document.getElementById('delete-movie-form').reset();

  document.getElementById('new-movie-form').style.display = 'block';
  document.getElementById('delete-movie-form').style.display = 'none'; // block is the default for showing a tag
  document.getElementById('update-movie-form').style.display = 'none';
});

document.getElementById('cancel-button2').addEventListener('click', (event) => {
  event.preventDefault();

  document.getElementById('new-movie-form').reset();
  document.getElementById('update-movie-form').reset();
  document.getElementById('delete-movie-form').reset();

  document.getElementById('new-movie-form').style.display = 'block';
  document.getElementById('delete-movie-form').style.display = 'none'; // block is the default for showing a tag
  document.getElementById('update-movie-form').style.display = 'none';
});

