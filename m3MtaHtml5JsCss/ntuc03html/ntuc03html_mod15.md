Module 15: Packaging JavaScript for Production Deployment
=== 
Contents:
- Module overview
- Lesson 1:	Understanding Transpilers And Module Bundling
- Lesson 2:	Creating Separate Packages for Cross Browser Support
- Lab:	Setting up Webpack Bundle for Production
- Module review and takeaways

## Module overview
### Objectives
After completing this module, you will be able to:
- Describe the reasons for using transpilers and module bundling.
- Create separate packages for cross-browser support.

## Lesson 1: Understanding Transpilers And Module Bundling
### Lesson objectives
After completing this lesson, you will be able to:
- Describe modules strategy in JavaScript.
- Describe the role of NodeJS and NPM and their importance in the compilation process.
- Describe the role of module bundlers and transpilers.

## Lesson 2: Creating Separate Packages for Cross Browser Support
### Lesson objectives
After completing this lesson, you will be able to:
- Describe webpack concepts and configuration.
- Describe Babel concepts and configuration.
- Describe Babel polyfills.

### Demonstration: Using Webpack and Babel to build a JavaScript App
### Demonstration steps
You will find the steps in the “Demonstration: Using Webpack and Babel to Build a JavaScript App“ section 
on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD15_DEMO.md.

## Lab: Setting up Webpack Bundle for Production
### Objectives
After completing this lab, you will be able to:
- Configure webpack and Babel and create a deploy package for a web project.

#### Lab setup
Estimated Time: 45 minutes

You will find the high-level steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD15_LAB_MANUAL.md.

You will find the detailed steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD15_LAK.md.

### Exercise 1: Creating Deploy Package using Webpack
#### package.json
``` yaml
{
  "version": "1.0.0",
  "name": "asp.net",
  "private": true,
  "scripts": {
    "webpack": "webpack"
  },
  "devDependencies": {
    "babel-core": "^6.26.3",
    "babel-loader": "^7.1.4",
    "babel-preset-es2015": "^6.24.1",
    "webpack": "^4.20.2",
    "webpack-cli": "^3.1.2"
  }
}
```

####  webpack.config.js
``` yaml
var path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: {
        video: './scripts/pages/video.js',
        feedback: './scripts/pages/feedback.js',
        live: './scripts/pages/live.js',
        location: './scripts/pages/location.js',
        locationVenue: './scripts/pages/location-venue.js',
        register: './scripts/pages/register.js',
        schedule: './scripts/pages/schedule.js',
        speakerBadge: './scripts/pages/speaker-badge.js',
        offline: './scripts/offline.js'
    },
    output: {
        path: path.resolve(__dirname,'dist'),
        filename: '[name].bundle.js',
        publicPath: '/dist/'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                loader: 'babel-loader',
                query: {
                    presets: ['es2015']
                }
            }
        ]
    },
    stats: {
        colors: true
    },
    devtool: 'source-map',
    mode: 'production'
};
// SIG // Begin signature block
// SIG // MIIdjAYJKoZIhvcNAQcCoIIdfTCCHXkCAQExCzAJBgUr
```
