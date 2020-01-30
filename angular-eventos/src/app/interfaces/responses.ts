import { Evento } from './evento';

export interface EventosResponse {
  ok: boolean;
  events?: Evento[];
  error?: string;
}

export interface EventoResponse {
  ok: boolean;
  event?: Evento;
  error?: string;
  errors?: string[];
}

export interface OkResponse {
  ok: boolean;
  error?: string;
}

