import React from 'react';

export default class Footer extends React.Component {
  constructor() {
    super();
  }

  render() {
    return  <footer>
              <div className='container'>
                <row>
                  <div className='col-sm-4'>
                    <h3>Left Footer Section</h3>
                  </div>
                  <div className='col-sm-4'>
                    <h3>Center Footer Section</h3>
                  </div>
                  <div className='col-sm-4'>
                    <h3>Right Footer Section</h3>
                  </div>
                </row>
              </div>
            </footer>;
  }
}