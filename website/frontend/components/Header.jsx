import React from 'react';

export default class InputArea extends React.Component {
  constructor() {
    super();
  }

  render() {
    return  <header>
              <div className='navbar navbar-default'>
                <div className='navbar-header'>
                  <a className='navbar-brand' href='javascript:void(0)'>
                    SQAT
                  </a>
                </div>

                <div className='navbar-collapse collapse.navbar-responsive-collapse'>
                  <ul className='nav navbar-nav'>
                    <li className='active'>
                      <a href='javascript:void(0)'>Home</a>
                    </li>
                    <li>
                      <a href='javascript:void(0)'>About</a>
                    </li>
                  </ul>

                  <form className='navbar-form navbar-left'>
                    <input className='form-control col-lg-8' type='text' placeholder='Search'>
                    </input>
                  </form>
                </div>
              </div>
            </header>;
  }
}