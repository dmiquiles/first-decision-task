import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { RouterTestingModule } from '@angular/router/testing';
import { ListarUsuariosComponent } from './listar-usuarios.component';

describe('ListarUsuariosComponent', () => {
  let component: ListarUsuariosComponent;
  let fixture: ComponentFixture<ListarUsuariosComponent>;

  beforeEach(() => {
    const usuarioServiceStub = () => ({
      listarTodos: () => ({ subscribe: () => ({}) }),
      deletar: () => ({ subscribe: () => ({}) })
    });
    TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [ListarUsuariosComponent],
      providers: [{ provide: UsuarioService, useFactory: usuarioServiceStub }]
    });
    fixture = TestBed.createComponent(ListarUsuariosComponent);
    component = fixture.componentInstance;
  });

  it('can load instance', () => {
    expect(component).toBeTruthy();
  });

  it(`displayedColumns has default value`, () => {
    expect(component.displayedColumns).toEqual([`id`, `nome`, `email`]);
  });

  describe('ngOnInit', () => {
    it('makes expected calls', () => {
      spyOn(component, 'listarTodos').and.callThrough();
      component.ngOnInit();
      expect(component.listarTodos).toHaveBeenCalled();
    });
  });

  describe('listarTodos', () => {
    it('makes expected calls', () => {
      const usuarioServiceStub: UsuarioService = fixture.debugElement.injector.get(
        UsuarioService
      );
      spyOn(usuarioServiceStub, 'listarTodos').and.callThrough();
      component.listarTodos();
      expect(usuarioServiceStub.listarTodos).toHaveBeenCalled();
    });
  });
});
