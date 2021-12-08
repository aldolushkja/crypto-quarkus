import './components/Navbar.js';
import './components/Footer.js';
import './components/Homepage.js';
import './components/Hashing.js';
import './components/Certificates.js';
import './components/Criptography.js';
import './components/DigitalSignatures.js';
import './components/CA.js';

import {Router} from './deps/vaadin-router.js';

// setup a Router instance
const outlet = document.getElementById('outlet');
const router = new Router(outlet);

router.setRoutes([
    {path: '/', component: 'c-home'},
    {path: '/hashing', component: 'c-hashing'},
    {path: '/criptography', component: 'c-criptography'},
    {path: '/certificates', component: 'c-certificates'},
    {path: '/ds', component: 'c-ds'},
    {path: '/ca', component: 'c-ca'},
]);