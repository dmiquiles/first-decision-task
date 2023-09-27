import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
// import { UsuarioRequest } from '../../models/usuario-request.model';
import { UsuarioService } from './usuario.service';
import { Usuario } from 'src/app/models/usuario.model';
// import { UsuarioResponse } from 'src/app/models/usuario-response.model';

describe('UsuarioService', () => {
  let service: UsuarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [UsuarioService]
    });
    service = TestBed.inject(UsuarioService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });

  describe('criar', () => {
    it('makes expected calls', () => {
      const httpTestingController = TestBed.inject(HttpTestingController);
      const usuarioRequestStub: Usuario = {
        "id": 1,
        "nome": "DVM",
        "email": "email@email",
        "senha": "1234567",
        "confirmacao": "1234567"
      };

      const usuarioResponseStub: Usuario = {
        "id": 1,
        "nome": "DVM",
        "email": "email@email",
        "senha": "1234567",
        "confirmacao": "1234567"
      };

      service.criar(usuarioRequestStub).subscribe(res => {
        expect(res).toEqual(usuarioResponseStub);
      });
      const req = httpTestingController.expectOne(
        'http://localhost:8080/api/usuarios'
      );
      expect(req.request.method).toEqual('POST');
      req.flush(usuarioRequestStub);
      httpTestingController.verify();
    });
  });

  describe('listarTodos', () => {
    it('makes expected calls', () => {
      const httpTestingController = TestBed.inject(HttpTestingController);
      service.listarTodos().subscribe(res => {
        expect(res).toEqual([]);
      });
      const req = httpTestingController.expectOne(
        'http://localhost:8080/api/usuarios'
      );
      expect(req.request.method).toEqual('GET');
      req.flush([]);
      httpTestingController.verify();
    });
  });
});
