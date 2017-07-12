import { Angular2BaseUiNothemePage } from './app.po';

describe('angular2-base-ui-notheme App', () => {
  let page: Angular2BaseUiNothemePage;

  beforeEach(() => {
    page = new Angular2BaseUiNothemePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
