import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router'
import { AngularFireAuth } from '@angular/fire/auth';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentpruebaComponent } from './components/componentprueba/componentprueba.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { ManteminientoComponent } from './components/manteminiento/manteminiento.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';

import {AngularFirestore, AngularFirestoreModule} from '@angular/fire/firestore';
import {AngularFireStorageModule, BUCKET} from '@angular/fire/storage';
import {AngularFireModule, FirebaseApp} from '@angular/fire';
import { environment } from 'src/environments/environment';

import * as firebase from 'firebase';

@NgModule({
  declarations: [
    AppComponent,
    ComponentpruebaComponent,
    UsuariosComponent,
    ManteminientoComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    // AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularFirestoreModule,
    AngularFireStorageModule

  ],
  providers: [
    {provide: BUCKET, useValue:'gs://hackatonbbva6.appspot.com'},
    AngularFireAuth,
    AngularFirestore
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
