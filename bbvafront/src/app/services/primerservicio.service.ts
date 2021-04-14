import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { Observable } from 'rxjs';
import { AngularFirestore } from '@angular/fire/firestore';
import { map } from 'rxjs/operators';
// import { auth } from 'firebase/app';
import firebase from "firebase/app";
import "firebase/auth";

@Injectable({
  providedIn: 'root'
})
export class PrimerservicioService {

  constructor(private afsAuth: AngularFireAuth, private afs: AngularFirestore) { }


}
