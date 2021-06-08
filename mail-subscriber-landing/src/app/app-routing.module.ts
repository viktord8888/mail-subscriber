import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ActivationComponent} from './activation/activation.component';
import {LandingComponent} from './landing/landing.component';
import {ConfirmationComponent} from './confirmation/confirmation.component';

const routes: Routes = [
  {path: '', component: LandingComponent},
  {path: 'landing', component: LandingComponent},
  {path: 'activate', component: ActivationComponent},
  {path: 'confirmation', component: ConfirmationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
