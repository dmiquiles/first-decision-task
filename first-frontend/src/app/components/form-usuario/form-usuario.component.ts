import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioForm } from 'src/app/models/usuario-form.model';
import { Usuario } from 'src/app/models/usuario.model';
// import { UsuarioRequest } from 'src/app/models/usuario-request.model';
import Validation from 'src/app/shared/utils/validation';

@Component({
  selector: 'app-form-usuario',
  templateUrl: './form-usuario.component.html',
  styleUrls: ['./form-usuario.component.scss']
})
export class FormUsuarioComponent implements OnInit {

  form: FormGroup;
  error: string;
  msgError: string;
  @Input() btnText: string;
  @Input() usuario!: Usuario;
  @Output() submit: EventEmitter<Usuario> = new EventEmitter<Usuario>();

  constructor(
    private router: Router
  ){
    this.form = new FormGroup({});
    this.btnText = '';
    this.error = '';
    this.msgError = '';
  }

  ngOnInit(): void {
    this.criarForm();
  }

  criarForm(): void {
    this.form = new FormGroup<UsuarioForm>({
      nome: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      senha: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]),
      confirmacao: new FormControl('', [Validators.required]),
    },
    {
      validators: [Validation.match('senha', 'confirmacao')]
    }
    );
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  onCancel(): void {
    this.router.navigate(['/']);
  }

  onSubmit(): void {
    this.submit.emit(this.form.value);
  }

}
