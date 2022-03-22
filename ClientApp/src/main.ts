import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import "bootstrap/dist/js/bootstrap.min.js";

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

export function getBaseUrl() {
  // return document.getElementsByTagName('base')[0].href;
  //return "https://www.alexandruleonte.com";
  if (environment.production) {
    return "https://www.alexandruleonte.com";
  } else {
    return "http://localhost";
  }
}

const providers = [
  { provide: 'BASE_URL', useFactory: getBaseUrl, deps: [] }
];

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic(providers).bootstrapModule(AppModule)
  .catch(err => console.error(err));
