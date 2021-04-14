import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComponentpruebaComponent } from './components/componentprueba/componentprueba.component';
import { HomeComponent } from './components/home/home.component';
import { ManteminientoComponent } from './components/manteminiento/manteminiento.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'usuarios',
    component: UsuariosComponent
  },
  {
    path: 'mantenimiento',
    component: ManteminientoComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
