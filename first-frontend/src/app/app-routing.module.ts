import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroUsuarioComponent } from './components/cadastro-usuario/cadastro-usuario.component';
import { ListarUsuariosComponent } from './components/listar-usuarios/listar-usuarios.component';

const routes: Routes = [
  {
    path: '',
    component: ListarUsuariosComponent
  },
  {
    path: 'cadastrar',
    component: CadastroUsuarioComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
