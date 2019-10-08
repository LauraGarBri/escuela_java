import { TestBed } from '@angular/core/testing';

import { RegistroRestService } from './registro-rest.service';

describe('RegistroRestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegistroRestService = TestBed.get(RegistroRestService);
    expect(service).toBeTruthy();
  });
});
