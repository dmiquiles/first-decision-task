import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Router } from '@angular/router';
// import { UsuarioRequest } from 'src/app/models/usuario-request.model';
import { NotificationService } from 'src/app/services/notification/notification.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { CadastroUsuarioComponent } from './cadastro-usuario.component';
import { Usuario } from 'src/app/models/usuario.model';

describe('CadastroUsuarioComponent', () => {
  let component: CadastroUsuarioComponent;
  let fixture: ComponentFixture<CadastroUsuarioComponent>;

  beforeEach(() => {
    const routerStub = () => ({ navigate: () => ({}) });
    const notificationServiceStub = () => ({ showMessage: () => ({}) });
    const usuarioServiceStub = () => ({
      criar: () => ({ subscribe: () => ({}) })
    });
    TestBed.configureTestingModule({
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [CadastroUsuarioComponent],
      providers: [
        { provide: Router, useFactory: routerStub },
        { provide: NotificationService, useFactory: notificationServiceStub },
        { provide: UsuarioService, useFactory: usuarioServiceStub }
      ]
    });
    fixture = TestBed.createComponent(CadastroUsuarioComponent);
    component = fixture.componentInstance;
  });

  it('can load instance', () => {
    expect(component).toBeTruthy();
  });

  it(`btnText has default value`, () => {
    expect(component.btnText).toEqual(`Cadastrar`);
  });

  describe('criarUsuario', () => {
    it('makes expected calls', () => {
      const usuarioRequestStub: Usuario = <any>{};
      const usuarioServiceStub: UsuarioService = fixture.debugElement.injector.get(
        UsuarioService
      );
      spyOn(usuarioServiceStub, 'criar').and.callThrough();
      component.criarUsuario(usuarioRequestStub);
      expect(usuarioServiceStub.criar).toHaveBeenCalled();
    });
  });
});
