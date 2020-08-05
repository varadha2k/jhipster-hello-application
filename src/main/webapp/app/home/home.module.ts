import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterhelloSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [JhipsterhelloSharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class JhipsterhelloHomeModule {}
