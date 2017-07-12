import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UiElementsPagePanelsComponent } from './ui-elements-page-panels.component';

describe('UiElementsPagePanelsComponent', () => {
  let component: UiElementsPagePanelsComponent;
  let fixture: ComponentFixture<UiElementsPagePanelsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UiElementsPagePanelsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UiElementsPagePanelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
