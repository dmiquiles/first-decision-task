import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
// import { UsuarioRequest } from 'src/app/models/usuario-request.model';
import { Usuario } from 'src/app/models/usuario.model';
import { NotificationService } from 'src/app/services/notification/notification.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.scss']
})
export class CadastroUsuarioComponent implements OnInit {

  btnText = 'Cadastrar';

  constructor(
    private usuarioService: UsuarioService,
    private notificationService: NotificationService,
    private router: Router
  ) {}

  ngOnInit(  ): void { }

  criarUsuario(usuario: Usuario) {
    this.usuarioService.criar(usuario).subscribe(() => {
      this.notificationService.showMessage('Cadastro feito com sucesso');
      this.router.navigate(['/']);
    })
  }

}
