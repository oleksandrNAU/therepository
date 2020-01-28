import { Pipe, PipeTransform } from '@angular/core';
import { Evento } from '../interfaces/evento';

@Pipe({
  name: 'eventoFilter'
})
export class EventoFilterPipe implements PipeTransform {

  transform(eventos: Evento[], search: string): Evento[] {
    if (search) {
      return eventos.filter(e => e.title.toLocaleLowerCase().includes(
        search.toLocaleLowerCase()
      ));
    }
    return eventos;
  }

}
