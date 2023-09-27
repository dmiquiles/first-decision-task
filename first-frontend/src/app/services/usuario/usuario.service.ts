import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EMPTY, Observable, catchError, map } from 'rxjs';
import { Usuario } from 'src/app/models/usuario.model';
import { NotificationService } from '../notification/notification.service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(
    private http: HttpClient,
    private notificationService: NotificationService
  ) { }

  listarTodos(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>('http://localhost:8080/api/usuarios').pipe(
      map((obj) => obj),
      catchError(() => this.handlerError())
    );
  }

  criar(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>('http://localhost:8080/api/usuarios', usuario).pipe(
      map((obj) => obj),
      catchError(() => this.handlerError())
    );
  }

  handlerError(): Observable<any> {
    this.notificationService.showMessage('Ocorreu um erro!', true)
    return EMPTY;
  }

}
