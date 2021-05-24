import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ActivationComponent} from './activation/activation.component';
import {LandingComponent} from './landing/landing.component';

const routes: Routes = [
  {path: '', component: LandingComponent},
  {path: 'landing', component: LandingComponent},
  {path: 'activate', component: ActivationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
