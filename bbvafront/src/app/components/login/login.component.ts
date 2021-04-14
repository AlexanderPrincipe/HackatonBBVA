import { Component, OnInit } from '@angular/core';
import firebase from "firebase/app";
import "firebase/auth";
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }


  provider: any;
  user: any;

  ngOnInit(): void {
    
  }

  onLoginFacebook() {
    firebase.initializeApp(environment.firebaseConfig);
    var provider = new firebase.auth.FacebookAuthProvider();
    this.provider = provider;

    firebase.auth().signInWithPopup(provider).then(function(result) {
      var user = result.user;
      console.log(user);

  })
  .catch((error) => {
    // Handle Errors here.
    var errorCode = error.code;
    var errorMessage = error.message;
    // The email of the user's account used.
    var email = error.email;
    // The firebase.auth.AuthCredential type that was used.
    var credential = error.credential;

    // ...
  });

  }

  logout() {
    firebase.auth().signOut().then(function() {
      console.log("sign out"); 
    }).catch(function(error) {
      console.log("Error logout")
    })
  } 



 

}
