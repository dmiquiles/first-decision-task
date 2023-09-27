import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario.model';
// import { UsuarioResponse } from 'src/app/models/usuario-response.model';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-listar-usuarios',
  templateUrl: './listar-usuarios.component.html',
  styleUrls: ['./listar-usuarios.component.scss']
})
export class ListarUsuariosComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'email'];
  dataSource: Usuario[];

  constructor(private usuarioService: UsuarioService) {
    this.dataSource = [];
  }

  ngOnInit(): void {
    this.listarTodos();
  }

  listarTodos(): void {
    this.usuarioService.listarTodos().subscribe({
      next: (usuario) => {
        this.dataSource = usuario;
      }
    })
  }

}
