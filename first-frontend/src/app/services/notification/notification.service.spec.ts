import { TestBed } from '@angular/core/testing';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NotificationService } from './notification.service';

describe('NotificationService', () => {
  let service: NotificationService;

  beforeEach(() => {
    const matSnackBarStub = () => ({ open: () => ({}) });
    TestBed.configureTestingModule({
      providers: [
        NotificationService,
        { provide: MatSnackBar, useFactory: matSnackBarStub }
      ]
    });
    service = TestBed.inject(NotificationService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });
});
