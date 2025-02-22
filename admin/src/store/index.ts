import Vue from 'vue'
import Vuex from 'vuex'
import { IAppState } from './modules/app'
import { IAdminState } from './modules/admin'

Vue.use(Vuex)

export interface IRootState {
  app: IAppState
  user: IAdminState
}

// Declare empty store first, dynamically register all modules later.
export default new Vuex.Store<IRootState>({})
