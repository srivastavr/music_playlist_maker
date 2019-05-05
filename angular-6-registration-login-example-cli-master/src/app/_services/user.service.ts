import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { User } from '../_models';
import { PlaylistData } from 'audio-player-ng/audio-player-ng/classes/interfaces';
var us={
    "title": "",
"group": "string",
"songs":  [{
"title": "string",
   "url": "http://www.macaronisoup.com/songs/mp3/ApplesPeachesPumpkinPie.mp3",
    "group": "string",
    "disc": "string",
    "duration": 132

}]};

@Injectable()
export class UserService {

    getplaylistbysuer(id) {
        //this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        return this.http.get<any[]>("http://localhost:4200/api/v1/getplaylist?userid="+id);
    }
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>("http://localhost:4200/api/v1/employees");
    }
    getAllsongs()
    {
        return this.http.get<User[]>("http://localhost:4200/api/v1/songs");
    }
    getsongs()
    {
        return this.http.get<PlaylistData>("http://localhost:4200/api/v1/songs1");
        
       // return this.http.get<any[us]>(us);
    }
    /* getById(id: number) {
        return this.http.get(`${environment.apiUrl}/users/` + id);
    }
 */
    register(user: User) {
        return this.http.post("http://localhost:4200/api/v1/adduser",user);
    }

    /* update(user: User) {
        return this.http.put(`${environment.apiUrl}/users/` + user.id, user);
    }

    delete(id: number) {
        return this.http.delete(`${environment.apiUrl}/users/` + id);
    } */
}