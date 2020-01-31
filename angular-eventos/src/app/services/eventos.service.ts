import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EventosResponse, EventoResponse, OkResponse } from '../interfaces/responses';

import { map } from 'rxjs/operators';
import { Evento } from '../interfaces/evento';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EventosService {

  constructor(private http: HttpClient) { }

  getEventos() {
    return this.http.get<EventosResponse>('/events').pipe(
      map(resp => {
        if (resp.ok) {
          return resp.events;
        } else {
          throw resp.error;
        }
      })
    );
  }

  addEvento(evento: Evento) {
    return this.http.post<EventoResponse>('/events', evento).pipe(
      map(resp => {
        if (resp.ok) {
          return resp.event;
        } else {
          throw resp.error || resp.errors;
        }
      })
    );
  }

  deleteEvento(id: number) {
    return this.http.delete<OkResponse>(`/events/${id}`).pipe(
      map(resp => {
        if (!resp.ok) {
          throw resp.error;
        }
      })
    );
  }
}
