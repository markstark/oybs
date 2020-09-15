import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { OybsSharedModule } from 'app/shared/shared.module';
import { OybsCoreModule } from 'app/core/core.module';
import { OybsAppRoutingModule } from './app-routing.module';
import { OybsHomeModule } from './home/home.module';
import { OybsEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    OybsSharedModule,
    OybsCoreModule,
    OybsHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    OybsEntityModule,
    OybsAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class OybsAppModule {}
