import { TestBed } from '@angular/core/testing';

import { PrimerservicioService } from './primerservicio.service';

describe('PrimerservicioService', () => {
  let service: PrimerservicioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrimerservicioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
