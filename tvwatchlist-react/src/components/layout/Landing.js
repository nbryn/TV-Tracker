import React, { Component } from "react";
import { Link } from "react-router-dom";

class Landing extends Component {
  render() {
    return (
      <div className="landing">
        <div className="light-overlay landing-inner text-dark">
          <div className="container">
            <div className="row">
              <div className="col-md-12 text-center">
                <h1 className="display-4 mb-4">Personal TV Watchlist</h1>
                <p className="lead">
                  Create an account to start adding Movies, Series and TV-Shows
                  to your own watchlist
                </p>
                <hr />
                <Link className="btn btn-lg btn-primary mr-2" to="/signup">
                  Sign Up
                </Link>
                <Link className="btn btn-lg btn-secondary mr-2" to="/signin">
                  Sign In
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Landing;
