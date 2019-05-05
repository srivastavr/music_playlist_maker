import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { HttpClient } from "@angular/common/http";

import { User } from '../_models';
import { UserService } from '../_services';
import { Observable } from 'rxjs';
import { OptionsPlayer, PlaylistData } from "audio-player-ng/audio-player-ng/classes/interfaces";
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit {
    sondata: SongData[] = [];
    pdata: PlaylistData;
    currentUser: User;
    users: User[] = [];
    //newname: String="";
    songs: any[] = [];
    options: OptionsPlayer;
    playlist: Observable<PlaylistData>;
    playlists: any;
    new_play: String = "default";
    checkbox: boolean;
    selectedOption: string;
    seclectedtoadd: string;
    constructor(private userService: UserService, private http: HttpClient, private modalService: NgbModal) {
        this.checkbox = false;
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.options = {
            width: 300,
            oscFillStyle: 'hsl(290, 45%, 49%)',
            oscStrokeStyle: 'hsl(110, 100%, 49%)'
        };
        this.playlist = this.http.get<PlaylistData>("http://localhost:4200/api/v1/songs1");
    }

    ngOnInit() {
        this.loadAllUsers();
        this.loadsongs();
        this.loadplaylist();
    }
    FieldsChange(values: any) {
        console.log(values.currentTarget.checked);
        this.checkbox = values.currentTarget.checked;
    }

    openLg(content, name: string) {
        this.seclectedtoadd = name;
        //debugger
        this.modalService.open(content, { size: 'lg' });
    }
    seclecterop(event) {
        const newVal = event.target.value;
        this.selectedOption = newVal;
    }
    onSubmit() {
        console.log(this.selectedOption);

    }
    loadplaylist() {
        this.userService.getplaylistbysuer(this.currentUser.id).pipe(first()).subscribe(data => {
            this.playlists = data;
            this.selectedOption = data[0].id;
        });
    }
    loadsongs() {
        this.userService.getAllsongs().pipe(first()).subscribe(songs => {
            this.songs = songs;
        });
    }
    public onChange(event): void {  // event will give you full breif of action
        const newVal = event.target.value;
        console.log(newVal);
    }
    /* deleteUser(id: number) {
        this.userService.delete(id).pipe(first()).subscribe(() => { 
            this.loadAllUsers() 
        });
    }
 */
    private loadAllUsers() {
        this.userService.getAll().pipe(first()).subscribe(users => {
            this.users = users;
        });
    }
}




































/**
 * Options player
 */
export interface OptionsPlayer {

    // width of the player
    width: number;

    // height of the graphics panel, default: 60px
    graphicsHeight?: number;

    // background-color of the oscilloscope panel
    oscFillStyle: string;

    // front color of the oscilloscope panel
    oscStrokeStyle: string;

    // background-color of the chartbar panel, default: "oscFillStyle"
    freqFillStyle?: string;

    // front color of the chartbar panel, default: "oscStrokeStyle"
    freqStrokeStyle?: string;

    // number of the of the bars of the chartbar panel, default: 32
    freqBars?: number;

    // the values of playlist position are the flex-direction values:
    // column-reverse (top), row (right), column (bottom), row-reverse (left);
    // default: column (bottom)
    playlistPosition?: string;

    // load the song duration from metadata, it makes a request for song, default: true
    loadDuration?: boolean;
}


/**
 * Song data
 */
export interface SongData {

    // title of the song
    title: string;

    // url of the song
    url: string;

    // group of the song if available
    group?: string;

    // disc of the song if available
    disc?: string;

    // duration of the song, if it is not available can be loaded from "options.loadDuration = true"
    duration?: number;
}

/**
 * Playlist data
 */
export interface PlaylistData {

    // title of the playlist or disc
    title: string;

    // group of the playlist if it is a disc
    group?: string;

    // the songs, array de SongData objects
    songs: SongData[];
}