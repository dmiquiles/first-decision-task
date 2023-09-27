import { FormControl } from "@angular/forms";

export interface UsuarioForm {
    nome: FormControl<string|null>;
    email: FormControl<string|null>;
    senha: FormControl<string|null>;
    confirmacao: FormControl<string|null>;
}